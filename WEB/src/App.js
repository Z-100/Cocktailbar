import React, {useEffect, useState} from "react";
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import Cookies from 'universal-cookie';
import Home from "./pages/static/Home";
import Login from "./pages/Login";
import Profile from "./pages/Profile";
import About from "./pages/static/About";
import Error from "./pages/static/Error";
import Footer from "./components/Footer"
import Navbar from "./components/Navbar";
import Register from "./pages/Register";
import Recommended from "./pages/Recommended";
import Search from "./pages/Search";
import CreateDrink from "./pages/CreateDrink";
import Impress from "./pages/static/Impress";

export default function App() {

    const [user, setUser] = useState({email: "", token: ""});
    const cookies = new Cookies();

    const childToParent = (email, token) => {
        console.log("[INFO] App.js - childToParent user changed")
        setUser({
            email: email,
            token: token
        });

        cookies.remove('email')
        cookies.remove('token')
        if (email.length > 0 && token.length > 0) {
            cookies.set('email', email, { path: '/' });
            cookies.set('token', token, { path: '/' });
        }
    }

    const setFromCookies = () => {
        if (cookies.get('token') === undefined || cookies.get('email') === undefined)
            return;

        setUser({
            email: cookies.get('email'),
            token: cookies.get('token'),
        });

        console.log(cookies.get('token'))
        console.log(user)
    }

    useEffect(setFromCookies, [])

    if (user.email.length > 0 && user.token.length > 0)
        return (
            <div className={"flex flex-col flex-nowrap justify-between h-screen bg-fifth"}>
                <Router>
                    <Navbar childToParent={childToParent} user={user}/>

                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/login" element={<Login childToParent={childToParent} user={user} />} />
                        <Route path="/register" element={<Register childToParent={childToParent} user={user} />} />

                        <Route path="/profile" element={<Profile childToParent={childToParent} user={user} />} />
                        <Route path="/create" element={<CreateDrink user={user} />} />

                        <Route path="/about" element={<About />} />
                        <Route path="/search" element={<Search />} />
                        <Route path="/recommended" element={<Recommended />} />
                        <Route path="/impress" element={<Impress />} />
                        <Route path="*" element={<Error />} />
                    </Routes>

                    <div />
                    <p>{user.email + " - " + user.token}</p>
                    <Footer />
                </Router>
            </div>
        );

    return (
        <div className={"flex flex-col flex-nowrap justify-between h-screen bg-fifth"}>
            <Router>
                <Navbar childToParent={childToParent} user={user}/>

                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/login" element={<Login childToParent={childToParent} user={user} />} />
                    <Route path="/register" element={<Register childToParent={childToParent} user={user} />} />

                    <Route path="/about" element={<About />} />
                    <Route path="/search" element={<Search />} />
                    <Route path="/recommended" element={<Recommended />} />
                    <Route path="/impress" element={<Impress />} />
                    <Route path="*" element={<Error />} />
                </Routes>

                 <div />
                <Footer />
            </Router>
        </div>
    );
}
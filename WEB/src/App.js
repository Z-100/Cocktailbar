import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
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
    return (
        <div className={"flex flex-col flex-nowrap justify-between h-screen bg-fifth"}>
            <Router>
                <Navbar/>

                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/register" element={<Register />} />
                    <Route path="/profile" element={<Profile />} />
                    <Route path="/about" element={<About />} />
                    <Route path="/search" element={<Search />} />
                    <Route path="/recommended" element={<Recommended />} />
                    <Route path="/create" element={<CreateDrink />} />
                    <Route path="/impress" element={<Impress />} />
                    <Route path="*" element={<Error />} />
                </Routes>

                 <div />
                <Footer />
            </Router>
        </div>
    );
}
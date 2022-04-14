import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Profile from "./pages/Profile";
import About from "./pages/About";
import Error from "./pages/Error";
import Footer from "./components/Footer"
import Navbar from "./components/Navbar";
import Register from "./pages/Register";

export default function App() {
    return (
        <Router>
            <Navbar/>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/profile" element={<Profile />} />
                <Route path="/about" element={<About />} />
                <Route path="*" element={<Error />} />
            </Routes>

            <Footer />
        </Router>
    );
}
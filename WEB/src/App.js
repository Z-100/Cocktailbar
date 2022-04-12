import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Profile from "./pages/Profile";
import About from "./pages/About";
import Error from "./pages/Error";

export default function App() {
    return (
        <Router>
            <nav>
                <Link to="/"> Home </Link>
                <Link to="/login"> Login </Link>
                <Link to="/profile"> Profile </Link>
                <Link to="/about"> About </Link>
            </nav>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/profile" element={<Profile />} />
                <Route path="/about" element={<About />} />
                <Route path="*" element={<Error />} />
            </Routes>
        </Router>
    );
}
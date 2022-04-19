import React from 'react';
import {Link} from "react-router-dom";


function Navbar() { // Make work
    if (sessionStorage.getItem('token') !== null) {
        return <LoggedInNavbar />;
    }
    return <GuestGreeting />;
}

function LoggedInNavbar() {
    return(
        <div className={"h-16 p-5 bg-primary sticky"}>
            <nav>
                <div className={"flex flex-row flex-nowrap justify-between items-center content-start"}>
                    <div>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/"> Home </Link>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/about"> About </Link>
                    </div>
                    <div>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to={{pathname: "/", loggedIn: false}}> Logout </Link>
                        <Link className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third"} to="/profile"> Profile </Link>
                    </div>
                </div>
            </nav>
        </div>
    );
}

function GuestGreeting() {
    return(
        <div className={"h-16 p-5 bg-primary align-content-center"}>
            <nav>
                <div className={"flex flex-row flex-nowrap justify-between items-center content-start"}>
                    <div>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/"> Home </Link>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/about"> About </Link>
                    </div>
                    <div>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/login"> Login </Link>
                        <Link className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third"} to="/register"> Register </Link>
                    </div>
                </div>
            </nav>
        </div>
    );
}

export default Navbar;
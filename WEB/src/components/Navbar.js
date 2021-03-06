import React, {useState} from 'react';
import {Link} from "react-router-dom";
import Cookies from "universal-cookie";

function Navbar({childToParent, user}) {

    if (user.token.length > 0) {
        return <LoggedInNavbar childToParent={childToParent} user={user}/>;
    }
    return <GuestGreeting />;
}

function LoggedInNavbar({childToParent, user}) {
    const logout = () => {
        let cookies = new Cookies()
        childToParent("", "")
        cookies.replace("email", "")
        cookies.replace("token", "")
    }

    return(
        <div className={"h-16 p-5 bg-primary sticky top-0"}>
            <nav>
                <div className={"flex flex-row flex-nowrap justify-between items-center content-start"}>
                    <div>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/"> Home </Link>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/search"> Search </Link>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/recommended"> Recommended </Link>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/about"> About </Link>
                    </div>
                    <div>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/create"> Create </Link>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/" onClick={logout}> Logout </Link>
                        <Link className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third"} to="/profile"> Profile </Link>
                    </div>
                </div>
            </nav>
        </div>
    );
}

function GuestGreeting() {
    return(
        <div className={"h-16 p-5 bg-primary align-content-center sticky top-0"}>
            <nav>
                <div className={"flex flex-row flex-nowrap justify-between items-center content-start"}>
                    <div>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/"> Home </Link>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/search"> Search </Link>
                        <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/recommended"> Recommended </Link>
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
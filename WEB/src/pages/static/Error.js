import React from 'react';
import {Link} from "react-router-dom";

function Error() {
    return(
        <div className={"w-screen flex flex-row align-center justify-center"}>
            <div>
                <div className={""}>
                    <h1 className={"text-white text-left text-8xl"}>Error 404</h1>
                    <h1 className={"text-white text-right text-5xl"}>Page not found</h1>
                </div>
                <div className={"mt-12"}>
                    <h1 className={"text-white text-xl"}>The page you were looking for doesn't exist!</h1>
                    <Link className={"text-fourth font-semibold hover:text-opacity-100"} to="/"> Return to Home </Link>
                </div>
            </div>
        </div>
    );
}

export default Error;
import React from 'react';
import {Link} from "react-router-dom";

function Footer() {
    return (
        <div className={"flex flex-row flex-nowrap justify-evenly h-12 p-2 bg-fourth align-baseline fixed inset-x-0 bottom-0"}>
            <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/impress"> Impress </Link>
            <Link className={"py-2 px-4 text-white font-semibold hover:text-fifth"} to="/help"> Need help? </Link>
        </div>
    );
}

export default Footer;
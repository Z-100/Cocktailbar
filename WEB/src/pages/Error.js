import React from 'react';
import {Link} from "react-router-dom";

function Error() {
    return(
        <div>
            <h1>Error 404. Page not found</h1>
            <nav>
                <Link to="/"> Return to home </Link>
            </nav>
        </div>
    );
}

export default Error;
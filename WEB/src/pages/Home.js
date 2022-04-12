import React from 'react';
import { useNavigate } from "react-router-dom";

function Home() {
    let navigate = useNavigate();

    return(
        <div>
            <h1>Home</h1>
            <button onClick={() => {navigate("/login")}}>To Login</button>
        </div>
    );
}

export default Home;
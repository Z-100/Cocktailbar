import React from 'react';

import Drink from "../components/Drink"

function Home() {
    let req = Drink;

    return(
        <div>
            <h1>Home</h1>
            <button onClick={() => {req()}}>Request</button>
        </div>
    );
}

export default Home;
import React from 'react';

import Drink from "../components/Drink"

function Home(loggedIn) {
    let req = Drink;

    if (!loggedIn) {
        sessionStorage.removeItem('token')
        console.log('Logged out')
    }

    return(
        <div className={"w-screen flex flex-row align-center justify-center"}>
            <div>
                <p>sas</p>
            </div>
            <div className={"flex flex-col flex-nowrap w-96"}>
                <div >
                    <h1 className={"text-3xl"}>Welcome to your</h1>
                    <h1 className={"text-6xl"}>Cocktail Bar</h1>
                </div>
                <div>
                    <p>Create and replicate your favourite recipes!</p>
                </div>
            </div>
            <div>
                <p>sas</p>
            </div>
        </div>
    );
}

export default Home;
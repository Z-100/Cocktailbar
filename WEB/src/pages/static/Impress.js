import React from 'react';

function Impress() {
    return(

        <div className={"w-screen flex flex-row align-center justify-center"}>
            <div>
                <div>
                    <h1 className={"text-white text-right text-5xl"}>Welcome to your</h1>
                    <h1 className={"text-white text-left text-8xl"}>Cocktailbar</h1>
                </div>
                <div className={"mt-12"}>
                    <h1 className={"text-white text-center text-xl"}>View and create your very own recipes!</h1>
                </div>
            </div>
            <div />
        </div>
    );
}

export default Impress;
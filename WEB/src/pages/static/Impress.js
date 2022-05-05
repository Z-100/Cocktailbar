import React from 'react';

function Impress() {
    return(

        <div className={"w-screen h-screen flex flex-row align-center justify-center"}>
            <div>
                <div>
                    <h1 className={"text-white text-left text-7xl"}>Impressum</h1>
                </div>
                <div className={"mt-12"}>
                    <h1 className={"text-white text-left text-3xl mb-5"}>Legal notice</h1>
                    <h1 className={"text-white text-left text-xl pl-2"}>
                        Information in accordance with section 5 WTF
                        <br />
                        <br />
                        Z-100
                        <br />
                        <br />
                        Lil Kleine Allee. 3
                        69420 Nice
                        <br />
                        <br />
                        Germany
                    </h1>
                </div>
            </div>
            <div />
        </div>
    );
}

export default Impress;
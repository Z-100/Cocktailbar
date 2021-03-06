import React, {useState} from 'react';
import insert from "../service/CreateNewRecipeService";

function CreateDrink({user}) {
    const [title, setTitle] = useState("")
    const [description, setDescription] = useState("")
    const [message, setMessage] = useState(null)


    const handleSubmit = (event) => {
        event.preventDefault();

        setMessage(null)

        insert(user.email, user.token, title, description)
            .catch(err => {
                console.log("Error Reading data " + err);
                setMessage("Something went wrong! Try again later.")
            });

        if (message === null) {
            setTitle("")
            setDescription("")
            setMessage("Success!")
        }
    }

    return(
        <div className={"w-screen flex flex-row align-center justify-center"}>
            <div className={"flex align-center justify-center -mt-7 mr-5"}>
                <div>
                    <h1 className={"text-white text-6xl"}>Create your own</h1>
                    <h1 className={"text-white text-9xl"}>Cocktail</h1>
                </div>
            </div>
            <div className={"flex align-center justify-center mt-7 ml-5"}>
                <div className={"w-100 flex bg-gray_trans p-4 flex-col flex-nowrap rounded-lg"}>
                    <form onSubmit={handleSubmit}>
                        <div className={"flex flex-col flex-nowrap"}>
                            <div className="mb-4">
                                <label className="block text-white text-sm font-bold mb-2">What's your drink's name?
                                    <input className="shadow appearance-none ring-third rounded w-full py-2 px-3 text-grey-darker bg-fifth"
                                           autoFocus
                                           type="text"
                                           placeholder="Enter a name"
                                           name="title"
                                           value={title}
                                           onChange={(e) => setTitle(e.target.value)}/>
                                </label>
                            </div>
                            <div className="mb-4">
                                <label className="block text-white text-sm font-bold mb-2">Describe your drink!
                                    <textarea className="shadow appearance-none rounded h-32 w-full py-2 px-3 text-grey-darker bg-fifth"
                                           placeholder="Enter a description"
                                           name="description"
                                           value={description}
                                           onChange={(e) => setDescription(e.target.value)}/>
                                </label>
                            </div>
                            <div className="flex items-center justify-between">
                                <h1 className={"-mt-6 text-red-600"}>{message}</h1>
                            </div>
                            <div className="flex items-center justify-between">
                                <></>
                                <input className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"} type="submit" value="Submit drink!" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default CreateDrink;
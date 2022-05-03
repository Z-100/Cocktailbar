import React, {useState} from 'react';
import insert from "../service/CreateNewRecipeService";
import Cookies from 'universal-cookie';

function Create() {
    const [title, setTitle] = useState("")
    const [description, setDescription] = useState("")
    const cookies = new Cookies();

    const handleSubmit = () => {
        insert(cookies.get("email"), cookies.get("token"), title, description)
            .then(response => {
                return response.json();
            }).then(data => {
                console.log(data)
            }).catch(err => {
                console.log("Error Reading data " + err);
            });
    }

    return(
        <div>
            <form onSubmit={handleSubmit}>
                <input className={"py-2 px-4 bg-fourth text-white font-semibold rounded-lg shadow-md hover:bg-third cursor-pointer"} type="submit" value="Create drink" />
            </form>
        </div>

    );
}

export default Create;
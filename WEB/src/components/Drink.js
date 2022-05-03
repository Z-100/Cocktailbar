const Drink = (props) => {
    return (
        <div className={"w-72 h-72 m-5 bg-fourth rounded-lg bg-gray_trans text-white shadow-lg shadow-cyan-500/50"}>
            <div className={"w-72 h-12 text-xl"}>
                <p className={"py-2 px-2 font-semibold overflow-ellipsis whitespace-nowrap overflow-hidden"}>{props.title}</p>
            </div>
            <div className={"w-72 h-8 px-2"}>
                <p>{props.rating} ⭐</p>
            </div>
            <div className={"w-72 h-52 p-2"}>
                <p className={"break-words overflow-hidden overflow-ellipsis"}>{props.description}</p>
            </div>
        </div>
    ); //TODO Set max length to 200ch
}

export default Drink;
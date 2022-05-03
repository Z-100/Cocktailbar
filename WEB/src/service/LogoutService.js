import Cookies from "universal-cookie";

function Logout() {
    const cookies = new Cookies();
    console.log("[INFO] Removing token: " + cookies.get("token"))
    cookies.remove("token")

    if (cookies.get("token") === undefined)
        console.log("[INFO] Removing token: Success")
    else console.log("[ERROR] Failed removing token")
}

export default Logout
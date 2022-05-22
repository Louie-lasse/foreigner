import React, { useEffect, useState } from "react";

const NavBar = ({ menuItems = [{route: "/", label: "Reload Page"}], brand = "BigBellyBins" }) => {

    const [toggle, setToggle] = useState(false)
    const [matches, setMatches] = useState(
        window.matchMedia("(min-width: 600px)").matches
    )

    useEffect(() => {
        window
            .matchMedia("(min-width: 600px)")
            .addEventListener('change', e => {
                setMatches(e.matches);
                setToggle(false);
            });
    }, []);

    const toggleHandler = () => {
        setToggle(!toggle);
    }


    const desktopMenu = (
        <ul className="flex last:pr-3">
            {menuItems.map(item => {
                return <a href={item.route} >{item.label}</a>
            })}
        </ul>
    );




    return (
        <nav style={{
            left: "0px",
            top: "0px",
            color:"#ffffffff",
            background:"#007868"}} >
            <h1 className="h-14 text-2xl font-bold px-7 flex items-center">{brand}</h1>
                    {!matches && <button onClick={toggleHandler}><i className="pr-4">fx</i></button>}
                {matches && desktopMenu}
        </nav>

    )
}

export default NavBar;


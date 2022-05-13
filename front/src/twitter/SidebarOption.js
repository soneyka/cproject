import React from 'react'
import './SidebarOption.css'

function SidebarOption({ active, text, Icon, handleLogout, handleUserProfile}) {

    return (
        <div className={`sidebarOption ${active && `sidebarOption--active`}`} onClick={text === 'Спотифай' ? ()=> window.open("https://whimsical-crostata-54d868.netlify.app/", "_self") : handleLogout != null ? handleLogout : handleUserProfile}>
            <Icon/>
            <h2>{text}</h2>
        </div>
    )
}

export default SidebarOption

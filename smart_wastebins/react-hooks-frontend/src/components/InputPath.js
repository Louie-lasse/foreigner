import { useState } from "react";
import BinService from "../services/BinService";
import InputBin from "./InputBin";

const InputPath = ({onSubmit}) => {


    const sendBins = (n) => {
        console.log(n+" bins sent");
        BinService.getBins(n).then(
            bins => onSubmit(bins.data)
        ).catch(
            error => console.log(error)
        )
    }

    return (
        <div>
            <InputBin onSubmit={n => sendBins(n)}/>
        </div>
    )
}

export default InputPath
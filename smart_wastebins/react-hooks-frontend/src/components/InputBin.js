import React from 'react';
import Button from "../styling/ButtonStyling";


const InputBin = ({onSubmit}) => {

    const handleSubmit=(e)=>{
        e.preventDefault();
        const nBins = e.target.numberOfBins.value;
        onSubmit(nBins);
      }

    return (

        <div className = "container" class="item_2">
           <form onSubmit={handleSubmit}>
                Antal papperskorgar : <input type="text" name="amount"/>
                Start : <input type="text" name="start"/>
                Slut : <input type="text" name="end"/>
                <Button theme= "lightBlue"  >
                    Display Bins
                </Button>
            </form>
        </div>
    )
}

export default InputBin
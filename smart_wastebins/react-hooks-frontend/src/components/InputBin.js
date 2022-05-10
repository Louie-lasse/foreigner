const InputBin = ({onSubmit}) => {

    const handleSubmit=(e)=>{
        e.preventDefault();
        const nBins = e.target.numberOfBins.value;
        console.log("Number of bins: " + nBins);
        onSubmit(nBins);
      }

    return (
        <div className = "container">
           <form onSubmit={handleSubmit}>
                <input
                    onKeyPress={(event) => {
                        if (!/[1-9]/.test(event.key)) {
                        event.preventDefault();
                        }
                    }}
                    name = "numberOfBins"
                    placeholder="Number Of Bins"
                />
                <button>
                    Collect wastebins
                </button>
            </form> 
        </div>
    )
}

export default InputBin
import './App.css';
import ListBinComponent from './components/ListBinComponent';

function App() {
const handleSubmit=(e)=>{
  e.preventDefault();
  const nBins = e.target.numberOfBins.value;
  console.log("Number of bins: " + nBins);
}

  return (
    <div>
      <ListBinComponent />
      <form onSubmit={handleSubmit}>
        <input
          onKeyPress={(event) => {
            if (!/[0-9]/.test(event.key)) {
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
  );
}

export default App;

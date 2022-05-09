import axios from 'axios'

const BIN_BASE_REST_API_URL = 'http://localhost:8081/api/v1/wastebins/';



class BinService {
    getAllBins() {
        return axios.get(BIN_BASE_REST_API_URL)
    }

    getBins(nBins) {
        return axios.get(BIN_BASE_REST_API_URL + nBins)
    }

}

export default new BinService();
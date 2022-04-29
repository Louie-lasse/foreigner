import axios from 'axios'

const BIN_BASE_REST_API_URL = 'http://localhost:8081/api/v1/wastebins';
const BIN_BASE_REST_API_URL1 = 'http://localhost:8081/api/v1/wastebins/5';

class BinService {
    getAllBins() {
        return axios.get(BIN_BASE_REST_API_URL)
    }

    getBins() {
        return axios.get(BIN_BASE_REST_API_URL1)
    }
}

export default new BinService();
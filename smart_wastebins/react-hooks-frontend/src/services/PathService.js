import axios from 'axios'

const PATH_BASE_REST_API_URL = 'http://localhost:8081/api/v1/path';

class PathService {

    getPath(lat, lng){
        return axios.get(PATH_BASE_REST_API_URL+'?latitude='+lat+'&longitude='+lng)
    }

}

export default new PathService();
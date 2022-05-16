import axios from "axios";
class BetService{

    getMatches(){
        return axios.get("http://localhost:8080/match/list", {
            headers: {
            Authorization: localStorage.getItem('token')
            }
        });
    }

    async getBets(matchId){
        const response = await axios.get("http://localhost:8080/bet/list-by-game", {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                game_id: matchId
            }
        });
        return response;
    }

    createBetslip(bets){
        console.log(bets);
        return axios.post("http://localhost:8080/bet-slip", {
            headers: {
            Authorization: localStorage.getItem('token')
            },
            params: {
                bets: bets,
                user_id: localStorage.getItem('id')
            }
        });
    }

    getBetslips(){
        return axios.get("http://localhost:8080/match", {
            headers: {
            Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id')
            }
        });
    }
}

export default new BetService();
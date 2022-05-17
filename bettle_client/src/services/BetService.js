import axios from "axios";
class BetService{

    getMatches(){
        return axios.get("http://localhost:8080/match/list", {
            headers: {
                Authorization: localStorage.getItem('token')
            }
        });
    }

    async getBetsByMatch(matchId){
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
        const qs = require('qs');

        return axios.post("http://localhost:8080/bet-slip", {}, {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id'),
                bets: bets
            },
            paramsSerializer: params => {
                return qs.stringify(params, { arrayFormat: 'repeat' })
            }
        });
    }

    async getBetSlips(){
        return await axios.get("http://localhost:8080/bet-slip/list-unshared", {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id')
            }
        });
    }

    playEditorBet(slipId){
        return axios.post("http://localhost:8080/bet-slip/save-editor-betslip", {}, {
            headers: {
                Authorization: localStorage.getItem('token')
            },
            params: {
                user_id: localStorage.getItem('id'),
                slipId: slipId
            }
        });
    }
}

export default new BetService();
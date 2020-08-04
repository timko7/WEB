Vue.component('login', {

    data: function() {
        return {
            user: {
                username: null,
                password: null
            },
            loggedUser: null,
            userLoggedIn: false
            
        }
    },

    template:
    `
    <div class="login-form" v-if="!userLoggedIn">
        <table>
            <tr><td><input type="text" placeholder="Unesite korisničko ime" v-model="user.username" /></td></tr>
            <tr><td><input type="password" placeholder="Unesite lozinku" v-model="user.password" /></td></tr>
            <tr><td><input type="button" value="Prijavi se" v-on:click="login()" /></td></tr>
            <tr><td colspan="2"><a href="#/registration">Nemaš nalog? Registruj se</a></td></tr>
        </table>
    </div>
    <div v-else-if="userLoggedIn">
    	<admin-page v-if="loggedUser.userType === 'ADMIN'" :user="loggedUser"></admin-page>
    	
<!--        <home-page-guest v-if="loggedUser.type === 'GUEST'" :user="loggedUser"></home-page-guest>
        <home-page-host v-if="loggedUser.type === 'HOST'" :user="loggedUser"></home-page-host> -->
        
    </div>
    `,

    methods: {
        login : function() {
            if (!this.checkIfInputsAreFilled()) {
                return;
            }

            axios.post('rest/log/login', this.user)
            .then(response => {
                if (response.data === '') { // user doesn't exists
                    toast('Nalog sa unetom kombinacijom korisničkog imena i lozinke ne postoji!');
                } else {
                    this.loggedUser = response.data;
                    console.log('Posle login: ', this.loggedUser.userState)
                    console.log('Posle login: ', this.loggedUser)
                    
                    if (this.loggedUser.userState === "BLOCKED") {
                        toast('Vaš nalog je blokiran! Ne možete se prijaviti na aplikaciju!'); 
                    } else {
                        this.userLoggedIn = true;
                    }
                }
            });
        },

        checkIfInputsAreFilled : function() {
            if (this.user.username == null || this.user.username.trim() === '') {
                toast('Niste uneli korisničko ime!!');
                return false;
            } else if (this.user.password == null || this.user.password.trim() === '') {
                toast('Niste uneli lozinku!!');
                return false;
            }

            return true;
        }
    },

    mounted() {
        axios.get('rest/log/getUser')
        .then(response => {
            this.loggedUser = response.data;
            this.userLoggedIn = (response.data === '') ? false : true; 
        });
    }

});
Vue.component('all-users', {
    data: function() {
        return {
            users: [],
            usersBackup: [],
            searchUsername: null,
            searchGender: null,
            searchType: null,
        }
    },

    template:
    `
    <div class='card'>
        <div class='card-header'>
            <h2>Svi korisnici sistema:</h2>
        </div>

        <div class='card-body'>
            <table class="table table-hover table-dark">
                <thead>
                    <tr>
                        <th scope="col">Korisničko ime</th>
                        <th scope="col">Ime</th>
                        <th scope="col">Prezime</th>
                        <th scope="col">Pol</th>
                        <th scope="col">Uloga</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in users">
                    	<td>{{user.username}}</td>
                		<td>{{user.name}}</td>
                		<td>{{user.surname}}</td>
                		<td>{{user.gender}}</td>
                		<td>{{user.userType}}</td>
                		<td>{{user.userState}}</td>
                    </tr>
                </tbody>
            </table>
            
            <table class="table table-hover w-50">
                
                <tbody>
                    <tr>
                        <th><label>Pretraži korisnike po korisničkom imenu:</label></th>
                        <td><input type="text" v-model="searchUsername"/></td>
                        <td><button type="button" class="btn btn-dark" v-on:click="searchByUsername()">Pretraži</button></td>
                    </tr>
                    <tr>
                        <th><label>Pretraži korisnike po polu:</label></th>
                        <td><input type="text" v-model="searchGender"/></td>
                        <td><button type="button" class="btn btn-dark" v-on:click="searchByGender()">Pretraži</button></td>
                    </tr>
                    <tr>
                        <th><label>Pretraži korisnike po ulozi:</label></th>
                        <td><input type="text" v-model="searchType"/></td>
                        <td><button type="button" class="btn btn-dark" v-on:click="searchByType()">Pretraži</button></td>
                    </tr>
    				<tr>
                        <td colspan="3"><button type="button" class="btn btn-dark btn-block" v-on:click="resetSearch()">Resetuj pretragu</button></td>
                    </tr>

                </tbody>
            </table>
        </div>
    </div>

    `,

    methods: {
    	getAllUsers : function() {
            axios.get('rest/data/getAllUsers').then(response => this.users = response.data);
            
        },
        
        searchByUsername : function() {
			toastt('Search username')
			if (this.usersBackup.length == 0) {
                this.usersBackup = this.users;
            } else {
                this.users = this.usersBackup;
            }

            let ret = [];

            for (let user of this.users) {
                if (user.username.toLowerCase() === this.searchUsername.toLowerCase()) {
                    ret.push(user);
                }
            }

            this.users = ret;
            //return ret;
		},
		
		searchByGender : function() {
            toastt('Search gender')
            if (this.usersBackup.length == 0) {
                this.usersBackup = this.users;
            } else {
                this.users = this.usersBackup;
            }

            let ret = [];

            for (let user of this.users) {
                if (user.gender.toLowerCase() === this.searchGender.toLowerCase()) {
                    ret.push(user);
                }
            }

            this.users = ret;
            //return ret;
		},
		
		searchByType: function() {
            toastt('Search type');
            if (this.usersBackup.length == 0) {
                this.usersBackup = this.users;
            } else {
                this.users = this.usersBackup;
            }

            let ret = [];

            for (let user of this.users) {
                if (user.userType.toLowerCase() === this.searchType.toLowerCase()) {
                    ret.push(user);
                }
            }

            this.users = ret;
            //return ret;
		},
		
		resetSearch: function() {
			if (this.usersBackup.length == 0) {
                this.usersBackup = this.users;
            }
			this.users = this.usersBackup;
		}

    },

    mounted() {
        this.getAllUsers();
    }
});
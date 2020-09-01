Vue.component('profile-settings', {
    data: function() {
        return {
            userInfo: {
                username: null,
                password: null,
                name: null,
                surname: null,
            },
            oldPassword: null,
            newPassword: null,
            againPassword: null,
        }
    },

    template:
    `
    
    
    <div>
        <h3>Podešavanje mog profila</h3>
        
        <table align="center" class="table-form">
        	<tr>
        		<td>Korisničko ime</td>
        		<td><label>{{ userInfo.username }}</label></td>
        	</tr>
        	<tr>
        		<td>Prethodna lozinka</td>
        		<td><input type="password" v-model="oldPassword" /></td>
        	</tr>
        	<tr>
        		<td>Nova lozinka</td>
        		<td>
        			<input type="password" v-model="newPassword" /><br />
        			(ostaviti prazno polje ako ne želite da menjate loznku)
        		</td>
        	</tr>
        	<tr>
        		<td>Ponovite novu lozinku</td>
        		<td>
        			<input type="password" v-model="againPassword" /><br />
        			(ostaviti prazno ako ne želite da menjate loznku)
        		</td>
        	</tr>
        	<tr>
        		<td>Ime</td>
        		<td><input type="text" v-model="userInfo.name" /></td>
        	</tr>
        	<tr>
        		<td>Prezime</td>
    			<td><input type="text" v-model="userInfo.surname" /></td>
        	</tr>
        	<tr>
        		<th colspan="2"><input type="button" value="Izmeni podatke" v-on:click="editProfile()" /></th>
        	</tr>
        </table>
    </div>
    `,

    methods: {

        editProfile : function() {
            if (this.oldPassword !== this.userInfo.password) {
                toast('Prethodna lozinka koju ste uneli nije ispravna!! Pokušajte ponovo!');
                return;
            }

            if (this.againPassword !== this.newPassword) {
                toast('Lozinke koje ste uneli se ne poklapaju!! Pokuštajte ponovo!');
                return;
            }

            if (this.newPassword !== null) {
                this.userInfo.password = this.newPassword;
            }

            axios.post('rest/data/userEdit', this.userInfo)
            .then(response => {
                if (response.data === '') { // user doesn't exists
                    toast('Greška prilikom izmene podataka!!');
                } else {
                    toast('Vaš profil je uspešno izmenjen');
                }
            });
        },
        
    },

    mounted() {
        axios.get('rest/log/getUser').then(response => this.userInfo = response.data);
    }
});
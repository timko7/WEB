Vue.component('all-users', {
    data: function() {
        return {
            users: [],
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
                        <th scope="col">Tip</th>
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
        </div>
    </div>

    `,

    methods: {
    	getAllUsers : function() {
            axios.get('rest/data/getAllUsers').then(response => this.users = response.data);
        },

    },

    mounted() {
        this.getAllUsers();
    }
});
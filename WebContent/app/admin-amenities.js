Vue.component('admin-amenities', {
    data: function() {
        return {
        	amenities: [],
        	amenityToAdd: {
        		id: null,
        		name: "",
        	},
        	amenityNewName: "",
        	amenityChangeName: "",
        	changeBool: false,
        }
    },

    template:
    `
    <div>
	    <div class='card'>
	        <div class='card-header'>
	            <h2>Lista sadržaja apartmana:</h2>
	        </div>
	        <div class='card-body'>
	            <table class="table table-hover table-dark w-50">
	                <thead>
	                    <tr>
	                        <th scope="col">Id sadržaja</th>
	                        <th scope="col">Naziv sadržaja</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr v-for="amenity in amenities" v-if="!amenity.deleted">
	                        <td>{{amenity.id}}</td>
                            <td>{{amenity.name}}</td>
                            <td><button type="button" class="btn btn-dark" v-on:click="deleteAmenity(amenity.name)">Obriši sadržaj</button></td>
                            <td><button type="button" class="btn btn-dark" @click="change(amenity.name)">Izmeni sadržaj</button></td>
	                    </tr>
	                </tbody>
	            </table>
	        </div>
	    </div>
	
	    <div class='card'>
	        <div class='card-header'>
	            <h2>Dodavanje novog sadržaja:</h2>
	        </div>
	        <div class='card-body'>
	            <table class="w-50 table-borderless">
	                <tr>
	                    <td>Naziv sadržaja</td>
	                    <td><input type="text" v-model="amenityToAdd.name"> </td>
	                </tr>
	                <tr>
	                    <td><button type="button" class="btn btn-dark" v-on:click="addAmenity()">Pošalji</button></td>
	                </tr>
	            </table>
	        </div>
        </div>
        
        <div class='card' v-if="changeBool">
	        <div class='card-header'>
	            <h2>Izmena sadržaja:</h2>
	        </div>
	        <div class='card-body'>
	            <table class="w-50 table-borderless">
	                <tr>
	                    <td>Novi naziv sadržaja</td>
	                    <td><input type="text" v-model="amenityNewName"> </td>
	                </tr>
	                <tr>
	                    <td><button type="button" class="btn btn-dark" v-on:click="changeAmenity()">Izmeni</button></td>
	                </tr>
	            </table>
	        </div>
        </div>
    </div>
    `,

    methods: {
    	getAllAmenities: function() {
            axios.get('rest/data/amenities').then(response => this.amenities = response.data);
		},
		
		addAmenity: function() {
			if (this.amenityToAdd.name === "" || this.amenityToAdd.name.trim() === "") {
				toastt('Uneli ste prazan string!\nMolimo ponovite..')
				return;
			}
			console.log('Pre katovanja! ', this.amenityToAdd.name)
			this.amenityToAdd.name = this.amenityToAdd.name.trim();
			console.log('Posle katovanja!', this.amenityToAdd.name)
			axios.post('rest/data/amenities', this.amenityToAdd)
			.then((response) => {
		        // Success 🎉
		        console.log(response);
		        console.log(response.data);
		        toastt('Uspešno ste dodali sadržaj apartmana!')
		        this.amenities.push(response.data)
		    })
		    .catch((error) => {
		        // Error 😨
		        if (error.response) {
		            /*
		             * The request was made and the server responded with a
		             * status code that falls out of the range of 2xx
		             */
		            console.log(error.response.data);
		            console.log(error.response.status);
		            console.log(error.response.headers);
		        } else if (error.request) {
		            /*
		             * The request was made but no response was received, `error.request`
		             * is an instance of XMLHttpRequest in the browser and an instance
		             * of http.ClientRequest in Node.js
		             */
		            console.log(error.request);
		        } else {
		            // Something happened in setting up the request and triggered an Error
		            console.log('Error', error.message);
		        }
		        console.log(error.config);
		        toastt('Greška prilikom dodavanja sadržaja apartmana!')
		    });
		},
		
		deleteAmenity(amenityName) {
			axios.post('rest/data/amenityDelete/' + amenityName)
			.then((response) => {
		        // Success 🎉
		        toastt('Uspešno ste logicko obrisali sadržaj apartmana! Učitajte ponovo stranicu!')
			})
			.catch((error) => {
		        // Error 😨
		        toastt('Greška prilikom logickog brisanja sadržaja apartmana!')
		    });
			return;
		},
		
		
		change(amenityName) {
			this.amenityNewName = amenityName;
			this.amenityChangeName = amenityName;
			this.changeBool = true;
			
		},
		
		changeAmenity() {
			if (this.amenityNewName.trim() === "") {
				toastt('Polje ne sme biti prazno!!')
			} else {
				axios.put('rest/data/amenityChangeName/' + this.amenityChangeName, this.amenityNewName)
				.then((response) => {
			        // Success 🎉
			        toastt('Uspešno ste promenili sadržaj apartmana! Učitajte ponovo stranicu!')
			        this.changeBool = false
				})
				.catch((error) => {
			        // Error 😨
			        toastt('Greška prilikom promene sadržaja apartmana!')
			    });
			}
		}
		
		
    },

    mounted() {
    	this.getAllAmenities();
    }
});

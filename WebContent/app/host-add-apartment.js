Vue.component('host-add-apartment', {
    data: function() {
        return {
        	apartmentToAdd: {
        		id: null, 
        		userNameHost: null,
        		apartmentType: null,
        		numberOfRooms: null,
        		numberOfGuests: null,
        		location: null,
        		dates: [], // entered dates for rent
        		freeDates: [],
        		comments: [],
        		pictures: [],
        		price: null,
        		timeCheckIn: null, // initial 2pm
        		timeCheckOut: null, // initial 10am
        		aprtmentStatus: null,
        		amenities: [],
        	}
        }
    },

    template:
    `
    <div class='card'>
        <div class='card-header'>
        	<h2>Dodavanje novog apartmana:</h2>
        </div>
        
        <div class='card-body'>
            <h3>Unesite sledece podatke:</h3>


            <table class="table w-100">
                <tr>
                    <td>Tip apartmana</td>
                    <td><select v-model="user.gender">
                            <option value="WHOLE_APARTMENT" selected>WHOLE_APARTMENT</option>
                            <option value="ROOM">ROOM</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Broj soba</td>
                    <td><input type="number" v-model="user.gender"> </td>
                </tr>
                <tr>
                    <td>Broj gostiju</td>
                    <td><input type="number" v-model="user.gender"> </td>
                </tr>
                <tr>
                    <td>Lokacija</td>
                    <!-- <td><input type="text" name="L" #L="ngModel" [(ngModel)]="sertifikat.l"> </td> -->
                </tr>
                <tr>
                    <td>Slike</td>
                    <!-- <td><input type="text" name="C" #C="ngModel" [(ngModel)]="sertifikat.c"> </td> -->
                </tr>
                <tr>
                    <td>Cena po noci</td>
                    <td><input type="number" v-model="user.gender"> </td>
                </tr>
                <tr>
                    <td>Vreme za prijavu</td>
                    <td><input type="number" v-model="user.gender" min="0" max="24" value="14"> </td>
                </tr>
                <tr>
                    <td>Vreme za odjavu</td>
                    <td><input type="number" v-model="user.gender" min="0" max="24" value="10"> </td>
                    </td>
                </tr>
                <tr>
                    <td>Sadrzaji (dodaci) apartmana</td>
                    <td><input type="number" name="UID" #UID="ngModel" [(ngModel)]="sertifikat.uid"> </td>
                </tr>

                <tr>
                    <td><button type="button" class="btn btn-dark" v-on:click="searchByType()">Posalji</button></td>
                </tr>


            </table>


        </div>
        
    </div>

    `,

    methods: {
    	
    },

    mounted() {
    	
    }
});
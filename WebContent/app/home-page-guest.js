Vue.component('home-page-guest', {
    data: function() {
        return {
            //currentComponent: 'admin-all-users',
        }
    },

    props: [
        'user',
    ],

    template:
    `
    <div align="center">
    	<h1>Home page guest!!</h1>
    	<li><a href="#" v-on:click="logout()">Odjavi se</a></li>
    </div>
    `,

    methods: {
        /** Switch between components for <component> tag */
//    	showComponent : function(componentName) {
//            this.currentComponent = componentName;
//        },

        /** Http request for logout */
        logout : function() {
    		axios.get('rest/log/logout').then(response => router.go('/'));
        },
        
    },

    mounted() {

    }
});
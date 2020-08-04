/* Components */
const componentLogin = { template: '<login></login>' };
const componentRegistration = { template: '<registration></registration>' };
 

const router = new VueRouter({
    mode: 'hash',
    routes: [
        { path: '/', component: componentLogin },
        { path: '/registration', component: componentRegistration },
    ]
});


let app = new Vue({
    router, 
    el: '#apartmentReservation'
});

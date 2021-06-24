//Js rész Vue segítségével


const vm = Vue.createApp({
    data() {
        return{
      ads: [],
      titles:"",
      description:""
        }
    },
    methods:{
        addNew(){
            axios.post("http://localhost:8080/ads/addAd", {
        title: this.title,
        description: this.description
    }).then(response => {
        console.log(response);
        this.list();
        this.title="";
        this.description="";
    })
    .catch(err => {
        console.log(err);
    });
        },
        list(){
            axios
            .get("http://localhost:8080/ads")
            .then(response => {
                console.log(response.data);
              this.ads = response.data
            })}
    },
    mounted() {
      this.list();
    }
  }).mount("#container");
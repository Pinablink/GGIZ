<template>
   <div class="container">
		<div id="login" class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Acesso</h3>
				</div>
				<div class="card-body">
					<form id="dataLogin">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="usuario" v-model="usuarioLogin">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" id="senhaLogin" class="form-control" placeholder="senha" v-model="senhaLogin">
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox">Lembrar-me
						</div>
						<div class="form-group">
							<input type="submit" value="Login" @click.prevent="postRequestLogin" class="btn float-right login_btn">
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Ainda n&atilde;o tem Cadastrado?<a href="#">Cadastrar-se</a><!-- <a v-on:click="openCadForm" href="#">Cadastrar-se</a> -->
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Esqueceu da Senha?</a>
					</div>
				</div>
			</div>
		</div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            usuarioLogin : '',
            senhaLogin : ''
        }
    },

    methods : {
        postRequestLogin () {
            if (this.usuarioLogin.trim() === '' ||  this.senhaLogin.trim() === '') {
                alert ('Informe Usuário e Senha para efetuar o login')
            } else {
               alert ('Esta feature esta sendo desenvolvida')      
            }
        }
    }
}
</script>>


<style>
.container{
height: 100%;
align-content: center;
}

.card{
height: 370px;
margin-top: auto;
margin-bottom: auto;
width: 400px;
background-color: rgba(0,0,0,0.5) !important;
}

.social_icon span{
font-size: 60px;
margin-left: 10px;
color: #FFC312;
}

.social_icon span:hover{
color: white;
cursor: pointer;
}

.card-header h3{
color: white;
}

.social_icon{
position: absolute;
right: 20px;
top: -45px;
}

.input-group-prepend span{
width: 50px;
background-color: #FFC312;
color: black;
border:0 !important;
}

input:focus{
outline: 0 0 0 0  !important;
box-shadow: 0 0 0 0 !important;

}

.remember{
color: white;
}

.remember input
{
width: 20px;
height: 20px;
margin-left: 15px;
margin-right: 5px;
}

.login_btn{
color: black;
background-color: #FFC312;
width: 100px;
}

.login_btn:hover{
color: black;
background-color: white;
}

.links{
color: white;
}

.links a{
margin-left: 4px;
}
</style>
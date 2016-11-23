var play = {
	"oSta" : document.getElementById("start"),
	"oUl" : document.getElementById("oul"),
	"oLi" : document.getElementById("li1"),
	"oBtn" : document.getElementById("btn"),
	"level" : 1,
	"n" : 1,
	// 初始化
	"init" : function(){
		this.oBtn.disabled = true;
		this.start();
	},
	// 开始
	"start" : function(){
		var This = this;
		This.oSta.onclick = function(){
			This.oSta.remove();
			This.oLi.remove();
			This.add();
		}
	},
	
	// 游戏倒计时
	"checked" : function(){
		alert("验证通过！");
		this.oBtn.disabled = false;
		return true;
	},
	// 添加图片
	"add" : function(){
		this.level = Math.round(Math.random()*10);
		this.n = Math.round(Math.random()*10);
		var aw = this.oUl.offsetWidth;
		for (var i = 0; i < this.level*this.level; i++) {
			var newLi = document.createElement("li");
			newLi.style.float = "left";
			newLi.style.width = aw/this.level + "px";
			newLi.style.height = aw/this.level + "px";
			newLi.style.backgroundColor = "rgb("+this.randcolor(255)+","+this.randcolor(255)+","+this.randcolor(255)+")";
			this.oUl.appendChild(newLi);
			var newImg = document.createElement("img");
			newImg.style.width = aw/this.level + "px";
			newImg.style.height = aw/this.level + "px";
			newImg.src = "img/1.png";
			newLi.appendChild(newImg);
		}
		var ran = this.randcolor(this.level*this.level);
		var alli = this.oUl.querySelectorAll("li");
		var oImg = alli[ran].children[0];
		oImg.src = "img/2.png";
		var This = this;
		var times = 1;
		alli[ran].onclick = function(){
			if(times)
			{
				if(This.checked())
				{	
					oImg.src = "img/3.jpg";
					times = 0;
				}
			}
		}
	},
	// 生成随机数
	"randcolor" : function(num){
		return Math.floor(Math.random()*num);
	}
}
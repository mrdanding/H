$(document).ready(function() {
	
	var person1 = {name:"aa", city:1, x:100, y:100, status:0};
	var person2 = {name:"bb", city:2, x:200, y:100, status:1};
	var person3 = {name:"cc", city:2, x:100, y:100, status:1};
	var ar = [person1, person2, person3];
	
	$(start_button).click(function() {
		$.getJSON("http://137.110.92.98:8080/getPeopleInfoAction", function(item, status) {
			canvas = document.getElementById("canvas");
			context = canvas.getContext("2d");
			context.clearRect(0,0,1000,560);
			context.restore();
			drawBackground();
			//alert("hehe");
			for (i=0;i<item.length;i++) {
				var person = item[i];
				var st = [];
				st.x = person.x;
				st.y = person.y;
				st.name = person.name;
				st.status = person.status;
				st.city = person.city;
				ar[st.name] = st;
				var x=person.x, y=person.y;
				if (parseInt(person.city) == 1) {
					x = parseInt(x) + 450;
				}
				if (parseInt(person.status) == "1"){
					context.fillStyle = "#000000";
					//alert(x + y);
					context.fillRect(x,y,10,10);
				}
			}
			$.getJSON("http://137.110.92.98:8080/getLogInfoAction", function(item, status) {
				//alert("haha");
				refreshInfo(item);
			});
		});
	});
	
	function drawBackground() {
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
 
		context.strokeRect(0,0,400,400);
		context.strokeRect(450, 0, 400, 400);
	}
	
	function refreshInfo(str) {
		var inf = str;
		$(info).text(inf);
	}
	
});






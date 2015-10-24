$(document).ready(function() {
	
	var person1 = {name:"aa", city:1, x:100, y:100, status:0};
	var person2 = {name:"bb", city:2, x:200, y:100, status:1};
	var person3 = {name:"cc", city:2, x:100, y:100, status:1};
	var persons = [];
	var ar = [person1, person2, person3];
	
	$(start_button).click(function() {
		var cnt = 0;
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
				if (person.city == 1) {
					x = parseInt(x) + 450;
				}
				if (person.status == 1){
					context.fillStyle = "000000";
				} else {
					context.fillStyle = "red";
				}
				context.fillRect(x,y,10,10);
			}
			$.getJSON("http://137.110.92.98:8080/getLogInfoAction", function(item, status) {
				//alert("haha");
				refreshInfo(item);
			});
		});
		
/*			
			while (true) {
				var now = new Date();
				var exitTime = now.getTime() + 10000;
				while (true) {
					now = new Date();
					if (now.getTime()>exitTime) break;
				}
				alert("ha");
				$.getJSON("http://137.110.92.98:8080/getPeopleInfoAction", function(item, status) {
					canvas = document.getElementById("canvas");
					context = canvas.getContext("2d");
					context.clearRect(0,0,1000,560);
					drawBackground();
					str = item.length;
					alert(str);
					for (i=0;i<item.length;i++) {
						var person = item[i];
						var name = person.name;
						if (persons[name]!="") {
							if (person.status == 0 && persons[name].status != 0) {
								person.status = 0;
								persons[name] = person;
								killPerson(persons[name]);
								str = name + " is killed!";
								refreshInfo(str);
							} else {
								persons[name] = person;
							}
						}
						drawPerson(person);
					}
				});
			}
		
*/		
	});
	
	function drawBackground() {
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
 
		context.strokeRect(0,0,400,400);
		context.strokeRect(450, 0, 400, 400);
	}
	
	function refreshInfo(str) {
		var inf = $(info).text() + '\n' + str;
		$(info).text(inf);
	}
	
	function drawPerson(person) {

		
	}
	
	function movePerson(person, xx, yy, city) {
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		var x=person.x, y=person.y;
		if (person.city == 1) {
			x = parseInt(x) + 450;
		}
		context.fillStyle="ffffff";
		context.fillRect(x,y,10,10);
		person.x = xx;
		person.y = yy;
		person.city = city;
		drawPerson(person);
	}
	
	function killPerson(person) {
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		var x=person.x, y=person.y;
		if (person.city == 1) {
			x+=450;
		}
		context.fillStyle="ffffff";
		context.fillRect(x,y,10,10);
	}
	
});






function toastt(sMessage) {
	var container = $(document.createElement("div"));
	container.addClass("toastt");

	var message = $(document.createElement("div"));
	message.addClass("message");
	message.text(sMessage);
	message.appendTo(container);

	container.appendTo(document.body);

	container.delay(500).fadeIn("slow", function() {
		$(this).delay(5000).fadeOut("slow", function() {
			$(this).remove();
		});
	});
}
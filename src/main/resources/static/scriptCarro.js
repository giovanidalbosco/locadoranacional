(function(){
    $("#tabcarros").on("click", ".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalcarro").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/carros/deletar/" + id,
            method: "GET",
            success: function() {
                window.location.href="/carros";
            }
        });
    });
})();
var datatable = null,idList=[];
$(function() {
    datatable = $('.table-sort').DataTable({
        aoColumnDefs: [
            {"bVisible": false, "aTargets": [0],} //控制列的隐藏显示
        ],
        buttons: [
           /* {
                'extend':'copyHtml5',
                'text':'复制',
                'title': '系统', //导出的excel标题
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            {
                'extend':'excelHtml5',
                'text':'下载Excel',
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            {
                'extend':'csvHtml5',
                'text':'下载cvs',
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            {
                'extend':'pdfHtml5',
                'text':'下载PDF',
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            'copyHtml5',
            'excelHtml5',
            'csvHtml5',
            'pdfHtml5',*/

            {
                'extend':'copy',
                'text':'复制',
                'title': '系统', //导出的excel标题
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            {
                'extend':'excel',
                'text':'下载Excel',
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            {
                'extend':'csv',
                'text':'下载cvs',
                'className':"btn btn-success radius",
                'exportOptions':{
                   /* 'modifier':{
                        'page':'current'
                    },*/
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            {
                'extend':'pdf',
                'text':'下载PDF',
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            {
                'extend':'print',
                'text':'打印',
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },
            {
                'extend':'colvis',
                'text':'打印',
                'className':"btn btn-success radius",
                'exportOptions':{
                    'modifier':{
                        'page':'current'
                    },
                    'columns':'0,2,3,4,5,6,7',
                }
            },


            //'copy', 'excel', 'pdf', 'print','colvis'
        ],
        ajax: {
            url: baselocation + "/menu/showPageMenu",
            type: 'post',
            data: function(d) {
                d.search = $('#search').val();
                d.state = $('#state').val();
                d.menuname = $('#pname').val();
            }
        },
        columns: [{
            data: null,
            orderable:false,
            render: function(data, type, row, meta) {
                var startIndex = meta.settings._iDisplayStart;
                return startIndex + meta.row + 1;
            }
        }, {
            data: "id",
            defaultContent: "",
            orderable:false,
            render: function(data, type, row, meta) {
                return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
            }
        }, {
            data: "menuname",
            defaultContent: "",
        }, {
            data: "pname",
            defaultContent: "",
        }, {
            data: "url",
            defaultContent: "",
        }, {
            data: "insertdatetime",
            render: function(data, type, row, meta) {
                return data ? new Date(data).pattern("yyyy-MM-dd HH:mm:ss") : '';
            }
        }, {
            data: "operatordatetime",
            render: function(data, type, row, meta) {
                return data ? new Date(data).pattern("yyyy-MM-dd HH:mm:ss") : '';
            }
        }, {
            data: "state",
            defaultContent: "",
            render: function(data, type, row, meta) {
                return '<span class="label label-' + clazz[data] + ' radius">' + text[data] + '</span>';
            }
        }, {
            data: "state",
            defaultContent: "",
            orderable:false,
            responsivePriority: 1,
            render: function(data, type, row, meta) {
                var a = "";
                a += '<a title="' + state[data] + '" style="text-decoration:none" onClick="changeStatus(' + "'" +  state[data] + "'" + ',[' + "'" + row.menuname + "'" + '],\'/menu/menuState\',' + row.id + ', '+ flag[data] + ')" href="javascript:;"><i class="Hui-iconfont">' + icon[data] + '</i></a>';
                a += '<a title="编辑" href="javascript:;" onclick="edit_show([' + "'" + row.menuname + "'" + '],\'/menu/edit\',' + row.id + ',\'893\',\'400\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
                a += '<a title="删除" href="javascript:;" onclick="del([' + row.id + '],\'/menu/delete\',[' + "'" + row.menuname + "'" + '],reloadTable)" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
                return a;
            }
        }],
    });


    $('#state').on('change',function(){
        datatable.ajax.reload();
    });


    //使用col插件实现表格头宽度拖拽
    $(".table-sort").colResizable();
});

/*$(document).ready(function() {
    var table = $('.table-sort').DataTable();

    $('.table-sort tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
    } );

    $('#button').click( function () {
        alert( table.rows('.selected').data().length +' row(s) selected' );
    } );
} );*/

//单机行，选中复选框
$("#table1 tr").slice(1).each(function(g){
    var p = this;
    $(this).children().slice(1).click(function(){
        $($(p).children()[0]).children().each(function(){
            if(this.type=="checkbox"){
                if(!this.checked){
                    this.checked = true;
                }else{
                    this.checked = false;
                }
            }
        });
    });
});

function reloadTable() {
    datatable.ajax.reload(null, false);
}

function getDTSelect() {
    var lines = datatable.rows('.selected').data();
    for (var i = 0; i < lines.length; i++) {
        idList.push(lines[i].id);
    }
    return idList;
}


$(document).keyup(function(event) {
    if (event.keyCode == 13) {
        $("#doSearch").trigger("click");
    }
});

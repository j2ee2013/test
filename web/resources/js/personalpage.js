/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


            function note() {
                window.alert("�����������ѡ����ڵ����ξ��㣬Ҳ���Ը�������ȥ�ĵط���������~");
            }
            function Ok_OnClick(event) {
                if (document.getElementsByName("textName")[0].value == "") {
                    alert("����������");
                    return;
                }
                var table;
                var tableList = document.getElementsByTagName("TABLE");
                for (var i = 0; i < tableList.length; i++) {
                    if (tableList[i].name == "tableName") {
                        table = tableList[i];
                                break;
                    }
                }
                var value = document.getElementsByName("textName")[0].value;
                var index = table.rows.length;
                table.insertRow(index);
                table.rows(index).insertCell(0);
                table.rows(index).cells(0).innerText = value;
                document.getElementsByName("textName")[0].value = "";
            }
            
            
                      function show_hiddendiv() {
                          document.getElementById("hidden_div").style.display = 'block';
                          document.getElementById("_strHref").href = 'javascript:hidden_showdiv();';
                          document.getElementById("_strSpan").innerHTML = "���ز���";
                      }
                      function hidden_showdiv() {
                          document.getElementById("hidden_div").style.display = 'none';
                          document.getElementById("_strHref").href = 'javascript:show_hiddendiv();';
                          document.getElementById("_strSpan").innerHTML = "��ʾȫ��";
                      }
<%@page import="com.ticket.dto.SelectedTicketDTO"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

	String step = request.getParameter("step");
	System.out.print("step: "+step);
	//String step = "1";

	String params = (String) request.getAttribute("params");
	String time = (String) request.getAttribute("time");

	//selectedTicketDTO stdto = (selectedTicketDTO)request.getAttribute("stdto");

	//System.out.println(hmap);

	SelectedTicketDTO stdto = (SelectedTicketDTO) request.getAttribute("stdto");

	//System.out.println(stdto + "454545454");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" href="/ticketing/resources/css/book.css"
	type="text/css" />
</head>


<body>

	<div style="vertical-align: top; float: left;">
		<div>
			<table width="200" bgcolor="#363636">
				<tr style="border-bottom-color: #ffffff;">
					<td><img src="/ticketing/resources/images/pic.PNG" /></td>
					<td><font size="1px" color="#ffffff">�ѻ»���<br />2018.
							06. 01 ~ 2019. 12. 31<br />���з� ������ƮȦ<br /></font></td>
				</tr>
			</table>
		</div>

		<table width="200" bgcolor="#363636">
			<tr>
				<td class="tdblack" colspan="2"></td>

			</tr>
		</table>

		<div>
			<table width="200" bgcolor="#363636">
				<tr>
					<td><font size="2px" color="#ffffff">���ó���</font></td>
				</tr>
				<tr>
					<td><font size="1px" color="#BFBFBF">��¥</font></td>
					<td><font size="1px" color="#ffffff">${stdto.getSelectedDate() }</font>
					</td>
				</tr>
				<tr>
					<td><font size="1px" color="#BFBFBF">�ð�</font></td>
					<td><font size="1px" color="#ffffff">${stdto.getTime() }</font></td>
				</tr>
				<tr>
					<td><font size="1px" color="#BFBFBF">�ż�</font></td>
					<td><font size="1px" color="#ffffff">${stdto.inwon }��</font></td>
				</tr>
				<tr>
					<td><font size="1px" color="#BFBFBF">�¼�</font></td>
					<td><font size="1px" color="#ffffff">��������</font></td>
				</tr>

				<tr height="30"></tr>

			</table>
		</div>

		<table width="200" bgcolor="#363636">
			<tr>
				<td class="tdblack" colspan="2"></td>

			</tr>
		</table>

		<div>
			<table width="200" bgcolor="#363636">
				<tr>
					<td><font size="2px" color="#ffffff">��������</font></td>
				</tr>
				<tr>
					<td><font size="1px" color="#BFBFBF">Ƽ�ϱݾ�</font></td>
					<td><font size="1px" color="#ffffff">40,000</font></td>
				</tr>
				<tr>
					<td><font size="1px" color="#BFBFBF">���ż�����</font></td>
					<td><font size="1px" color="#ffffff">500</font></td>
				</tr>
				<tr>
					<td><font size="1px" color="#BFBFBF">��۷�</font></td>
					<td><font size="1px" color="#ffffff">0</font></td>
				</tr>
				<tr>
					<td><font size="1px" color="#C3E3FA">�� �ݾ�(+)</font></td>
					<td><font size="1px" color="#ffffff">40,500</font></td>
				</tr>
			</table>
		</div>

		<table width="200" bgcolor="#363636">
			<tr>
				<td colspan="2"
					style="border-bottom-width: 1px; border-bottom-style: dotted; border-bottom-color: #000000"></td>

			</tr>
		</table>



		<div>
			<table width="200" bgcolor="#363636">
					<tr>
						<td><font size="1px" color="#BFBFBF">���αݾ�</font></td>
						<td><font size="1px" color="#ffffff">${stdto.discountPrice*stdto.inwon }</font> </td>
					</tr>
					<tr>
						<td><font size="1px" color="#BFBFBF">��������</font> </td>
						<td><font size="1px" color="#ffffff">${stdto.couponPrice*stdto.inwon }</font> </td>
					</tr>
					<tr>
						<td><font size="1px" color="#BFBFBF">Yes�Ӵ�</font> </td>
						<td><font size="1px" color="#ffffff">${stdto.pointPrice }</font> </td>
					</tr>
					<tr>
						<td><font size="1px" color="#BFBFBF">��ġ��</font> </td>
						<td><font size="1px" color="#ffffff"></font> </td>
					</tr>
					<tr>
						<td><font size="1px" color="#BFBFBF">YES��ǰ��</font> </td>
						<td><font size="1px" color="#ffffff"></font> </td>
					</tr>
					<tr>
						<td><font size="1px" color="#BFBFBF">�������ű�</font> </td>
						<td><font size="1px" color="#ffffff"></font> </td>
					</tr>
					<tr>
						<td><font size="1px" color="#BFBFBF">��Ÿ����</font> </td>
						<td><font size="1px" color="#ffffff"></font> </td>
					</tr>
					<tr>
						<td><font size="1px" color="#C3E3FA">�� ���αݾ�(-)</font> </td>
						<td><font size="1px" color="#ffffff">${stdto.discountPrice*stdto.inwon+stdto.couponPrice*stdto.inwon-stdto.pointPrice }</font> </td>
					</tr>
			</table>	
			</div>

		<table width="200" bgcolor="#363636">
			<tr>
				<td class="tdblack" colspan="2"></td>

			</tr>
		</table>

		<div>
			<table width="200" bgcolor="#363636">
				<tr height="9">
					<td></td>
				</tr>
				<tr>
					<td><font size="1.5px" color="#ffffff">���� ����
							�ݾ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>
					<td><font size="4px" color="#ffffff"><b>40,500</b></font><font
						size="2px;" color="#ffffff">��</font></td>
				</tr>
			</table>
		</div>
		<%
			if (step.equals("1")) {
		%>

		<div>
			<table width="200" bgcolor="#363636">
				<tr height="9">
					<td></td>
				</tr>
				<tr>
					<td><input type="button"
						style="width: 180px; height: 35px; margin-left: 7px;"
						id="detail_btn" value="�����ܰ�"
						onclick="javascript:location.href='<%=cp%>/step2.action';"></td>
				</tr>
				<tr height="15">
					<td></td>
				</tr>
			</table>
		</div>
	</div>

	<%
		} else if (step.equals("3")) {
	%>
	<div>
		<table width="200" bgcolor="#363636">
			<tr height="9">
				<td></td>
			</tr>
			<tr>
				<td><input type="button"
					style="color: #ffffff; width: 88px; height: 35px; margin-left: 7px; background-color: #818181; border-color: #818181;"
					value="�����ܰ�"
					onclick="javascript:location.href='<%=cp%>/step2.action';">
				</td>
				<td><input type="button" id="detail_btn"
					style="width: 88px; height: 35px;" value="�����ܰ�"
					onclick="javascript:location.href='<%=cp%>/step4.action';"></td>
			</tr>
			<tr height="15">
				<td></td>
			</tr>
		</table>
	</div>
	

	<%
		} else if (step.equals("4")) {
	%>

	<div>
		<table width="200" bgcolor="#363636">
			<tr height="9">
				<td></td>
			</tr>
			<tr>
				<td><input type="button"
					style="color: #ffffff; width: 88px; height: 35px; margin-left: 7px; background-color: #818181; border-color: #818181;"
					value="�����ܰ�"
					onclick="javascript:location.href='<%=cp%>/step3.action';"></td>
				<td><input type="button" id="detail_btn"
					style="width: 88px; height: 35px;" value="�����ܰ�"
					onclick="javascript:location.href='<%=cp%>/step5.action';"></td>
			</tr>
			<tr height="15">
				<td></td>
			</tr>
		</table>
	</div>
	


	<%
		} else if (step.equals("5")) {
	%>

	<div>
		<table width="200" bgcolor="#363636">
			<tr height="9">
				<td></td>
			</tr>
			<tr>
				<td><input type="button"
					style="color: #ffffff; width: 88px; height: 35px; margin-left: 7px; background-color: #818181; border-color: #818181;"
					value="�����ܰ�"
					onclick="javascript:location.href='<%=cp%>/step4.action';"></td>
				<td><input type="button" id="detail_btn"
					style="width: 88px; height: 35px;" value="�����ϱ�"></td>
			</tr>
			<tr height="15">
				<td></td>
			</tr>
		</table>
	</div>
	

	<%
		}
	%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	.property-name:hover {
		cursor: pointer;
		background-color: silver;
		margin-right: 10px;
	}
	.property-value{
		margin-left: 10px;
		background-color: lime;
	}
</style>
<form id="insertForm" method="post" action="<%=request.getContextPath() %>/09/property" class="row">
	<div class="col-auto">
	    <label for="propertyName" class="form-label">Property Name</label>
		<input type="text" name="propertyName" id="propertyName" placeholder="propertyName" class="form-control"/>
  	</div>
  	<div class="col-auto">
  		<label for="propertyValue" class="form-label">Property Value</label>
		<input type="text" name="propertyValue" id="propertyValue" placeholder="propertyValue" class="form-control"/>
  	</div>
  	<div class="col-auto">
  		<label for="description" class="form-label">Description</label>
		<input type="text" name="description" id="description" placeholder="description" class="form-control"/>
  	</div>
  	<div class="col-auto">
		<button type="submit" class="btn btn-primary">신규등록</button>
  	</div>
</form>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form id="updateForm">
	      <div class="modal-body">
	        <input type="text" name="propertyName" class="form-control" placeholder="property name" readonly />
	        <input type="text" name="propertyValue" class="form-control" placeholder="property value"/>
	        <input type="text" name="description" class="form-control" placeholder="description"/>
	        <input type="date" name="propDate" class="form-control" placeholder="propDat"/>
	        <input type="datetime" name="propTimestamp" class="form-control" placeholder="propTimestamp"/>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">UPDATE</button>
	      </div>
      </form>
    </div>
  </div>
</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/09/propView.js?<%=System.currentTimeMillis()%>"></script>














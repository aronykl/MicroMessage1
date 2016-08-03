
/**
 * 调用后台批量删除方法
 */
function batchDelete(basePath){
	$("#mainForm").attr("action", basePath + "deleteBatchService.action");
	$("#mainForm").submit();
}
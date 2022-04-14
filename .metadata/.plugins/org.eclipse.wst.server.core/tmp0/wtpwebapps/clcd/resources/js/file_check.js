/** 첨부 파일 관련 처리 함수 */

$(document).on('change', '#attach-file', function() {
	var attached = this.files[0];  // 현재 태그의 0번지 값을 attached 에 할당
	if ( attached ) { // 첨부된 파일이 있을 경우 파일명을 나타내고 delete 이미지도 표시함. 
		$('#file-name').text(attached.name);
		$('#delete-file').css('display', 'inline');
	} else {
		$('#file-name').text('');
		$('#delete-file').css('display', 'none');
	}	
}).on('click', '#delete-file', function(){ 	// 첨부 파일 삭제버튼 클릭시
	$('#file-name').text('');
	$('#delete-file').css('display', 'none');
	
	$('#attach-file').val('');	// 파일 태그에 첨부된 파일 정보 없애기	
});













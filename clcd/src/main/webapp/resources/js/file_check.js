/** 첨부 파일 관련 처리 함수 */

$(document).on('change', '#attach-file', function() {
	var attached = this.files[0];  // 현재 태그의 0번지 값을 attached 에 할당
	if ( attached ) { // 첨부된 파일이 있을 경우 파일명을 나타내고 delete 이미지도 표시함. 
		$('#file-name').text(attached.name);
		$('#delete-file').css('display', 'inline');
		// 이미지 파일인 경우 미리보기(#preview)에 보여지게 처리
		if ( $('#preview').length > 0 ) {  // id=preview 가 있으면
			if( isImage( attached.name ) ) { // 이미지 파일이면 미리보기 처리하고
				$('#preview').html('<img src="" id="preview-img" /> ');
				
				var reader = new FileReader();
				reader.onload = function(e) { // 파일 읽기 처리
					$('#preview-img').attr('src', e.target.result);
				}
				reader.readAsDataURL( attached );
			} else 
				$('#preview').html('');	// 이미지 파일이 아니면 미리보기 처리하지 않음
		}
	} else {
		$('#file-name').text('');
		$('#delete-file').css('display', 'none');
	}	
}).on('click', '#delete-file', function(){ 	// 첨부 파일 삭제버튼 클릭시
	if ($('#preview').length > 0) $('#preview').html('');	// id=preview 가 있으면 안 보이게 	
	$('#file-name').text('');
	$('#delete-file').css('display', 'none');
	
	$('#attach-file').val('');	// 파일 태그에 첨부된 파일 정보 없애기	
});

/* 이미지 파일 여부 확인 함수 */
function isImage(filename) {
	// abc.txt, abc.png, abc.123.hwp ... 확장자 부분만 잘라내기
	 var ext = filename.substring(filename.lastIndexOf('.')+1).toLowerCase();
	 
	 var imgs = ['png', 'jpg', 'gif', 'jpeg', 'bmp', 'pcx', 'tiff'];
	 
	 if ( imgs.indexOf(ext) > -1 ) return true;
	 else return false;
}













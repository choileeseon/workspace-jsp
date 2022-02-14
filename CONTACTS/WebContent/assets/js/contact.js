//console.log('테스트');
(function(path){
    //코드 작성
    $('.table').DataTable({
        language: {
            lengthMenu: '표시할 줄수 선택    _MENU_',
            search: '검색',
            paginate: { 'previous': '이전', 'next': '다음' },
            info: "페이지 _PAGE_ / _PAGES_",
            nfoEmpty: '데이터가 없습니다.',
            infoFiltered: "(전체 페이지 _MAX_ 에서 검색)",
            thousands: ','
        },
        lengthMenu: [5, 10, 25],  //한 페이지 표시할 줄수 
        pageLength: 5,            //페이지의 갯수
        ordering: false,          //열의 정렬기능(삭제)
        stateSave: true           
    }); //datatables사이트에서 제공하는 테이블 기능사용

    //추가 버튼을 클릭하면 => 모달이 표시됨
    $('.btn-add').click(function(e){
        //제이쿼리 변수는 $로 시작하며, 객체를 가져올때는 $('')로 가져옴
        const $modal =  $('#modal-add-update');
        // 모달의 #title-add-upd 를 찾음 -> h5태그안의 텍스트를 수정
        $modal.find('#title-add-upd').text('새 연락처');
        // form 태그의 action 속성을 수정 ,post가 새로운 정보 입력 저장
        $modal.find('form').attr('action',path + '/contact?cmd=post');
    });
})(path);
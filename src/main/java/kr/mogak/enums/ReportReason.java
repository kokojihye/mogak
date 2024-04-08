package kr.mogak.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ReportReason {
    AGGRESIVE("공격적인 내용이 포함되어 있어요."),
    VIOLENT("혐오발언이 포함되어 있어요."),
    ETC("기타: 상세사유를 작성할게요.");

    private final String reportReasonName;
}

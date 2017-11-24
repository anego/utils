package io.github.anego.utils;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * テスト用のデータモデル.
 *
 * @author murakoshi &#60;hiroshi_murakoshi@sedec.co.jp&#62;
 *
 */
@Getter
@Setter
public class TestModel {


    private Integer number;

    private String str;

    private Integer ary1;
    private Integer ary2;


    private Date day;

    private LocalDateTime localDay;
}
